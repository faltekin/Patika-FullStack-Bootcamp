public class Student {

    Course course1;
    Course course2;
    Course course3;
    String name;
    String stuNo;
    String classes;
    double avarage;
    boolean isPass;

    Student(String name,String stuNo,String classes,Course course1,Course course2,Course course3){

        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
        this.avarage = 0.0;
        this.isPass = false;
    }

    void  addBulkExamNote(int note1,int note1P,int note2,int note2P,int note3,int note3P){

        if (note1 >= 0 && note1 <= 100){
            this.course1.note = note1;
        }
        if (note1P >= 0 && note1P <= 100){
            this.course1.notePlus = note1P;
        }
        if (note2 >= 0 && note2 <= 100){
            this.course2.note = note2;
        }
        if (note2P >= 0 && note2P <= 100){
            this.course2.notePlus = note2P;
        }
        if (note3 >= 0 && note3 <= 100){
            this.course3.note = note3;
        }
        if (note3P >= 0 && note3P <= 100){
            this.course3.notePlus = note3P;
        }


    }

    void isPass(){

        //this.avarage = (this.course1.note + this.course2.note + this.course3.note) / 3.0;

        this.avarage = (((this.course1.notePlus * this.course1.noteAvarage1)+(this.course1.note*this.course1.noteAvarage2))+((this.course2.notePlus * this.course2.noteAvarage1)+(this.course2.note*this.course2.noteAvarage2))+((this.course3.notePlus * this.course3.noteAvarage1)+(this.course3.note*this.course1.noteAvarage2))) / 3;

        if (this.avarage > 55){
            System.out.println("Başarılı");
            this.isPass = true;

        } else {

            System.out.println("Başarısız");
            this.isPass = false;
        }


        printNote();
    }


    void printNote(){

        System.out.println(this.course1.name+" Notu : "+this.course1.note);
        System.out.println(this.course2.name+" Notu : "+this.course2.note);
        System.out.println(this.course3.name+" Notu : "+this.course3.note);
        System.out.println("Ortalama : "+this.avarage);
    }

}
