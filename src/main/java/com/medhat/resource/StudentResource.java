package com.medhat.taskone;

import com.medhat.StudentService;
import com.medhat.model.Student;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@RequestScoped
@Transactional
@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {


    @Inject
    private StudentService studentService;

    @GET
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }


    @GET
    @Path("/{id}")
    public Response getStudentById(@PathParam("id") Long id) {
        Student s = studentService.findById(id);
        if(s ==null)
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(s).build();
    }

    @POST
    public Response CreateStudent(Student s) {
        studentService.create(s);
        return Response.status(Response.Status.CREATED).entity(s).build();
        //Response Codes
    }
}