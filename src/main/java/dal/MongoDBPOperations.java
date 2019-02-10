package dal;

import common.entities.Doctor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class MongoDBPOperations {
    public void saveDoctor(MongoOperations mongoOperation, Doctor doctor) {

        mongoOperation.save(doctor);
        System.out.println("Doctor saved successfully");
        // doctor object got created with id.
        System.out.println("doctor : " + doctor);
    }

    public void searchDoctor(MongoOperations mongoOperation, String critera,String value) {
        // query to search doctor
        Query searchDoctor = new Query(Criteria.where(critera).is(value));

        // find doctor based on the query
        Doctor resultDoctor = mongoOperation.findOne(searchDoctor, Doctor.class);
        System.out.println("Doctor found!!");
        System.out.println("Doctor details: " + resultDoctor);
    }

    public void updateDoctor(MongoOperations mongoOperation, String critera,String value, String updateCriteria, String updateValue) {
        // query to search doctor
        Query searchDoctor = new Query(Criteria.where(critera).is(value));
        mongoOperation.updateFirst(searchDoctor, Update.update(updateCriteria, updateValue),
                Doctor.class);
        System.out.println("Doctor got updated successfully");
    }
    public void getAllDoctor(MongoOperations mongoOperation) {
        List<Doctor> listDoctor = mongoOperation.findAll(Doctor.class);
        for(Doctor doctor:listDoctor) {
            System.out.println("Doctor = " + doctor);
        }
    }
    public void removeDoctor(MongoOperations mongoOperation, String critera,String value) {
        Query searchDoctor = new Query(Criteria.where(critera).is(value));
        mongoOperation.remove(searchDoctor, Doctor.class);
        System.out.println("Doctor removed successfully!! ");
    }
}
