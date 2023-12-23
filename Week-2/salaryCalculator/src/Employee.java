public class Employee {

    String name;
    double salary;
    int workHours;
    int hireYear;
    double bonus;
    int year;
    double salaryNew;

    Employee(String name,double salary,int workHours,int hireYear){

        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
        this.bonus = 0.0;
        this.year = 2021;
        this.salaryNew = 0.0;

    }
    public double tax(){

        if (this.salary < 1000){
            return 0.0;
        } else return this.salary*0.03;
    }
    public double bonus(){

        if (this.workHours > 40){
            bonus = (this.workHours - 40) * 30;
        } else bonus = 0.0;

        return bonus;
    }
    public double raiseSalary(){

        if (year - this.hireYear < 10){
            salaryNew =  this.salary*0.05;
        }
        if ((year - this.hireYear > 9) && (year - this.hireYear < 20)){
            salaryNew =  this.salary*0.10;
        }
        if (year - this.hireYear > 19){
            salaryNew =  this.salary*0.15;
        }
        return salaryNew;
    }

    public double sum(){

        double sum = this.salary + bonus() + raiseSalary() - tax();
        return sum;
    }

    public String toString(){

        return "Adı : "+this.name +"\nMaaşı : "+this.salary+"\nÇalışma Saati : "+this.workHours+"\nBaşlangıç Yılı : "+this.hireYear+"\nVergi : "+this.tax()+"\nBonus : "+bonus()+"\nMaaş Artışı : "+raiseSalary()+"\nVergi ve Bonuslar ile birlikte maaş : "+(sum()-raiseSalary())+"\nToplam Maaş : "+sum();

    }



}
