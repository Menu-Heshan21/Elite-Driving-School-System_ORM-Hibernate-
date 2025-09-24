package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        return (boFactory == null) ? (boFactory = new BOFactory()) : boFactory;
    }

    public enum BOTypes {
        USER,
        STUDENT,
        INSTRUCTOR,
        COURSE,
        LESSON,
        PAYMENT,
        ROLE
    }

    public SuperBo getBO(BOTypes boType) {
        switch (boType) {
            case USER:
                return new UserBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case INSTRUCTOR:
                return new InstructorBOImpl();
            case COURSE:
                return new CourseBOImpl();
            case LESSON:
                return new LessonBOImpl();
            case PAYMENT:
                return new PaymentBOImpl();
            case ROLE:
                return new RoleBOImpl();
            default:
                return null;
        }
    }
}