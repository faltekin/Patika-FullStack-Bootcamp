

public class Main {
    public static void main(String[] args) {

        Teacher t1 = new Teacher("Alper Hoca","TRH","555");
        Teacher t2 = new Teacher("Sena Hoca","FZK","000");
        Teacher t3 = new Teacher("Hasan Hoca","BIO","1111");

        Course tarih = new Course("Tarih","101","TRH");
        tarih.addTeacher(t1);

        Course fizik = new Course("Fizik","102","FZK");
        fizik.addTeacher(t2);

        Course biyo = new Course("Biyoloji","101","BIO");
        biyo.addTeacher(t3);


        Student s1 = new Student("Ege","123","4",tarih,fizik,biyo);
        s1.addBulkExamNote(100,60,15,29,23,79);
        s1.isPass();

    }
}