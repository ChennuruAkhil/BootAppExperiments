package com.example.BootAppExperiments.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CollegeDto {

    private String collegeName;
    private String collegeCode;
    private String universityCode;
    private List<Branch> branches;
}
