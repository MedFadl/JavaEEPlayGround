package com.medhat.resource;

import com.medhat.dtos.StudentRequestDTO;
import com.medhat.dtos.StudentResponseDTO;
import com.medhat.service.StudentService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@RequestScoped
@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {


    @Inject
    private StudentService studentService;

    @GET
    public Response getAllStudents() {
        List<StudentResponseDTO> student = studentService.findAll();
        return student.isEmpty() ? Response.noContent().build() : Response.ok(student).build();
    }


    @GET
    @Path("/{id}")
    public Response getStudentById(@PathParam("id") Long id) {
        StudentResponseDTO student = studentService.findById(id);
        return Response.ok(student).build();
    }

    @POST
    @Valid
    public Response CreateStudent(StudentRequestDTO student) {
        StudentResponseDTO createdStudent = studentService.create(student);
        return Response.status(Response.Status.CREATED).entity(createdStudent).build();

    }
}