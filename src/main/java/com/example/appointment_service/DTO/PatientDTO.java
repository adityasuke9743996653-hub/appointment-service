package com.example.appointment_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
	private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String emailId;
    private String contactNumber;
}
