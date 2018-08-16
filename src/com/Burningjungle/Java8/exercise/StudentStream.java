package Java8.exercise;

import com.sun.org.glassfish.external.statistics.Statistic;
import sun.plugin2.message.BestJREAvailableMessage;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStream {
    private static List<Student> register(){
        Student student1 = new Student(1L,"JHW",Student.Gender.MALE,100,LocalDate.of(2016,Month.SEPTEMBER,1),Student.Department.AM);
        Student student2 = new Student(2L,"ZHW",Student.Gender.MALE,200,LocalDate.of(2016,Month.SEPTEMBER,1),Student.Department.AM);
        Student student3 = new Student(3L,"NYQ",Student.Gender.MALE,300,LocalDate.of(2016,Month.SEPTEMBER,1),Student.Department.AM);
        Student student4 = new Student(4L,"JJH",Student.Gender.MALE,400,LocalDate.of(2016,Month.SEPTEMBER,1),Student.Department.AM);
        Student student5 = new Student(5L,"SJY",Student.Gender.FEMALE,500,LocalDate.of(2016,Month.SEPTEMBER,1),Student.Department.AM);
        Student student6 = new Student(6L,"TYY",Student.Gender.FEMALE,400,LocalDate.of(2016,Month.SEPTEMBER,1),Student.Department.AM);
        Student student7 = new Student(7L,"FJP",Student.Gender.MALE,300,LocalDate.of(2016,Month.SEPTEMBER,1),Student.Department.AM);
        Student student8 = new Student(8L,"FJ",Student.Gender.MALE,200,LocalDate.of(2016,Month.SEPTEMBER,1),Student.Department.AM);
        Student student9 = new Student(9L,"ZYQ",Student.Gender.MALE,100,LocalDate.of(2016,Month.SEPTEMBER,1),Student.Department.AM);

        return Arrays.asList(student1,student2,student3,student4,student5,student6,student7,student8,student9);
    }

    private static void _(Object o){
        System.out.println(o);
    }
    private static void _(String prefix,Object o){
        System.out.println(o);
    }

    public static void main(String[] args) {
        List<Student> students = register();
        Stream<Student> studentStream = students.stream();
        _(students);

        //total number of students
        int studentCount = students.stream().mapToInt(s -> 1).sum();
        _("Total number of students is : " , studentCount);

        //total credit
        int studentCredit = students.stream().mapToInt(Student::getCredit).sum();
        _("Total credit of students is : " , studentCredit);

        //
        Map<Student.Gender,Long> groupCountByGender = students.stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
        _("Student group by gender is : " , groupCountByGender);

        //Student with Best
        Optional<Student> studentWithMaxCredit = students.stream()
                .max((student1 ,student2) -> student1.getCredit() - student2.getCredit());

                if (studentWithMaxCredit.isPresent()){
                    _("Student with max credit is :",studentWithMaxCredit.get().getName());
                    _("Max credit is :",studentWithMaxCredit.get().getCredit());
                }else {
                    _("can't get");
                }

        LongSummaryStatistics creditStats = students.stream().map(Student::getCredit)
                .collect(LongSummaryStatistics::new,
                        LongSummaryStatistics::accept,
                        LongSummaryStatistics::combine);
                _("credit stats :",creditStats);

                LongSummaryStatistics creditStats2 = students.parallelStream()
                        .collect(Collectors.summarizingLong(Student::getCredit));
                _("credit sum",creditStats2);

                Integer sumCredit = students.stream()
                        .reduce(0,
                                (Integer partialSum,Student student) -> {
                            Integer midlleSum =  partialSum + student.getCredit();
                            return midlleSum;
                                },
                                (a, b) -> {
                            return a + b;
                                });
                _("The sum credit" ,sumCredit);
    }
}
