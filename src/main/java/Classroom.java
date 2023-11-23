import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
public class Classroom {
    

    private String id;
    private Course course;
    private Student[] participants;
    private String room;
    private String term;


    private Classroom() {
        Date createdDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(createdDate);
        int month = cal.get(Calendar.MONTH);

        if (month >= Calendar.OCTOBER || month <= Calendar.FEBRUARY) {
            this.term = "WS" + cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.YEAR) + 1 - 2000);
        } else {
            this.term = "SS" + cal.get(Calendar.YEAR);
        }
    }

    public Classroom(Course course, String room) {
        this();
        this.course = course;
        this.room = room;

    }

    public Classroom(Course course, String room, Date date) {
        this(course, room);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);

        if (month >= Calendar.OCTOBER || month <= Calendar.FEBRUARY) {
            this.term = "WS" + cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.YEAR)  -2000+1 );
        } else {
            this.term = "SS" + cal.get(Calendar.YEAR);
        }

    }

    public Course getCourse() {
        return this.course;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String newRoom) {
        this.room = newRoom;
    }

    public String getTerm() {
        return this.term;
    }

    public String getID() {
        this.id = this.course.getID() + "-" + this.term;

        return this.id;
        
    }

    public void addStudent(Student student){
        
        if(this.participants == null){
            this.participants = new Student[1];
            this.participants[0] = student;
        }else{
            Student[] temp = new Student[this.participants.length+1];
            for(int i = 0; i < this.participants.length; i++){
                temp[i] = this.participants[i];
            }
            temp[this.participants.length] = student;
            this.participants = temp;
        }
    }


    public String getParticipantsEmail(){
        String emails = "";
        for(int i = 0; i < this.participants.length; i++){
            emails += this.participants[i].getEmail();
            if(i < this.participants.length-1){
                emails += ", ";
            }
        }
        return emails;
    }

    public int getTotalParticipants(){
        return this.participants.length;
    }


}
