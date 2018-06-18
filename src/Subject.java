import java.util.ArrayList;

public class Subject {
    private String nameOfSubject;   // Наименование предмета
    private int countOfLabs;        // Общее количество лаб по предмету
    private int protectedLabs;      // Количество сданных лаб по предмету

    // Конструктор
    public Subject(String nameOfSubject, int countOfLabs, int countOfProtectedLabs) {
        this.nameOfSubject = nameOfSubject;
        this.countOfLabs = countOfLabs;
        this.protectedLabs = countOfProtectedLabs;
    }

    // Getters
    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public int getCountOfLabs() {
        return countOfLabs;
    }

    public int getProtectedLabs() {
        return protectedLabs;
    }

    //  Список предметов хранится в контейнере
    public static ArrayList<Subject> listSubjects = new ArrayList<Subject>();

    // Сколько осталось сдать лабораторных работ по предмету
    public static int getCountOfUnprotectedLabs(Subject subject) {
        return subject.countOfLabs - subject.protectedLabs;
    }

    // Прогресс сдачи лаб в процентах
    public static float progressInPersentage(Subject subject) {
        return (float) 100 / subject.countOfLabs * subject.protectedLabs;
    }

    //  Добавить предмет в контейнер
    public static void setSubjectToTheList(Subject subject) {
        listSubjects.add(subject);
    }

    // Получить список предметов из контейнера
    public static void getListOfSubjects() {
        for (Subject subj : listSubjects) {
            System.out.println("Предмет: " + subj.getNameOfSubject());
            System.out.println("Надо сдать: " + subj.getCountOfLabs());
            System.out.println("Сдано: " + subj.getProtectedLabs());
            System.out.println("Осталось сдать: " + getCountOfUnprotectedLabs(subj));
            System.out.println("Прогресс: " + progressInPersentage(subj) + "%");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        setSubjectToTheList(new Subject("Нечеткая логика и нейронные сети", 8, 5));
        setSubjectToTheList(new Subject("Электронный бизнес", 13, 12));
        setSubjectToTheList(new Subject("Информационный менеджмент", 8, 5));
        setSubjectToTheList(new Subject("Управление проектами", 6, 3));
        setSubjectToTheList(new Subject("Функциональное программирование", 4, 1));
        setSubjectToTheList(new Subject("Дискретная математика", 12, 3));
        setSubjectToTheList(new Subject("Линейная алгебра", 50000, 31453));
        setSubjectToTheList(new Subject("Таможенный менеджмент", 100, 7));
        setSubjectToTheList(new Subject("Экономика", 15, 3));

        getListOfSubjects();
    }
}