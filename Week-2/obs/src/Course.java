import java.util.*;

public class Course {

    Teacher teacher;                                    // Kursa öğretmen ataması yapmak için
    String name;
    String code;
    String prefix;
    int note;
    int notePlus;
    double noteAvarage1;
    double noteAvarage2;


     Course(String name, String code, String prefix) {
        this.name = name;
        this.code = code;
        this.prefix = prefix;
        int note = 0;
        int notePlus = 0;

        if (prefix == "TRH"){
            this.noteAvarage1 = 0.20;
            this.noteAvarage2 = 0.80;
        } else if (prefix == "FZK"){
            this.noteAvarage1 = 0.30;
            this.noteAvarage2 = 0.70;
        } else if(prefix == "BIO"){
            this.noteAvarage1 = 0.60;
            this.noteAvarage2 = 0.40;
        }


    }

    void addTeacher(Teacher teacher){

         if (teacher.branch.equals(this.prefix)){
             this.teacher = teacher;
             //printTeacher();
         } else {
             System.out.println("Öğretmen ve Ders bölümleri uyuşmuyor !");
         }


        //printTeacher();
    }

    void  printTeacher(){
        this.teacher.print();
    }





}

