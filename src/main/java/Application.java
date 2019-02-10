import common.entities.Doctor;
import config.MongoConfig;
import dal.MongoDBPOperations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class Application {

    public static void main(String[] args) {

        // For Annotation
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        MongoDBPOperations ops = new MongoDBPOperations();

        Doctor doctor = new Doctor("John", "Smith");

        //save doctor
        ops.saveDoctor(mongoOperation, doctor);

        // get doctor based on search criteria
        ops.searchDoctor(mongoOperation, "firstName", "John");

        //update doctor based on criteria
        ops.updateDoctor(mongoOperation, "firstName", "John", "lastName", "Smith");
        // get doctor based on search criteria
        ops.searchDoctor(mongoOperation, "firstName", "John");

        // get all the doctors
        ops.getAllDoctor(mongoOperation);

        //remove doctor based on criteria
        ops.removeDoctor(mongoOperation, "firstName", "John");
        // get all the doctors
        ops.getAllDoctor(mongoOperation);
    }
}
