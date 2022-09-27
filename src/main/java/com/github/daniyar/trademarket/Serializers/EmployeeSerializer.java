package com.github.daniyar.trademarket.Serializers; // importing packages

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.daniyar.trademarket.POJO.Employee;
import com.github.daniyar.trademarket.POJO.Job;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeSerializer extends StdSerializer<Employee> { // Serializer is a
    // technology used to create GET http requests for objects which have connections with other objects (database connections) or the other situation where code developer does not need to get too many data inside object json
    // this is serializer for secure data. That implies that during http requests users will get whole pieces of data with sensitive data inclusive

    protected EmployeeSerializer(Class<Employee> t) {
        super(t);
    } // parametrized constructor

    public EmployeeSerializer() {
        this(null);
    } // empty constructor

    @Override
    public void serialize(Employee employee, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException { // main method for serialization

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("employeeId", employee.getId()); // displaying object parameter in JSON
        jsonGenerator.writeStringField("firstName", employee.getFirstName()); // displaying object parameter in JSON
        jsonGenerator.writeStringField("lastName", employee.getLastName()); // displaying object parameter in JSON
        jsonGenerator.writeStringField("status", employee.getStatus()); // displaying object parameter in JSON
        jsonGenerator.writeStringField("region", employee.getRegionName()); // displaying object parameter in JSON
        jsonGenerator.writeStringField("profileDescription", employee.getProfileDescription()); // displaying object parameter in JSON
        jsonGenerator.writeStringField("dateOfBirth", employee.getDateOfBirth()); // displaying object parameter in JSON
        jsonGenerator.writeStringField("mobilePhone", employee.getMobilePhone()); // displaying object parameter in JSON
        jsonGenerator.writeStringField("email", employee.getEmail()); // displaying object parameter in JSON
        jsonGenerator.writeStringField("password", employee.getPassword()); // displaying object parameter in JSON
        jsonGenerator.writeNumberField("paypalPurse", employee.getCreditCardId()); // displaying object parameter in JSON
        jsonGenerator.writeStringField("employeeUserRole", String.valueOf(employee.getRole())); // displaying object parameter in JSON

        jsonGenerator.writeArrayFieldStart("jobs"); // creating ArrayFieldStart for jobs -> (Employee and Job tables have one-to-many relationship) -> that's why in Employee class set of Job objects is stored
        Collection<Job> jobs = employee.getJobs(); // getting jobs Collection from Employee object

        for (Job job : jobs) { // looping through list of jobs objects
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", job.getId()); // displaying object parameter in JSON
            jsonGenerator.writeStringField("jobName", job.getJobName()); // displaying object parameter in JSON
            jsonGenerator.writeStringField("jobDescription", job.getJobDescription()); // displaying object parameter in JSON
            jsonGenerator.writeStringField("paymentSum", job.getPaymentSum()); // displaying object parameter in JSON
            jsonGenerator.writeStringField("requirements", job.getRequirements()); // displaying object parameter in JSON
            jsonGenerator.writeStringField("responsibilities", job.getResponsibilities()); // displaying object parameter in JSON
            jsonGenerator.writeStringField("workingTerms", job.getWorkingTerms()); // displaying object parameter in JSON
            jsonGenerator.writeStringField("dateOfCompletion", job.getDateOfCompletion()); // displaying object parameter in JSON
            jsonGenerator.writeNumberField("durationInHours", job.getDuration()); // displaying object parameter in JSON
            jsonGenerator.writeStringField("placeOfPerformance", job.getPlaceOfPerformance()); // displaying object parameter in JSON
            jsonGenerator.writeStringField("processStatus", job.getProcessStatus()); // displaying object parameter in JSON
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();


        jsonGenerator.writeEndObject();
    }
}
