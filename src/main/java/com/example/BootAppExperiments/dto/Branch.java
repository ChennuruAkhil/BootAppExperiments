package com.example.BootAppExperiments.dto;

import lombok.Getter;

@Getter
public enum Branch {
    EEE("Electrical and Electronics Engineering"),
    ECE("Electronics and Communication Engineering"),
    ME("Mechanical Engineering"),
    CSE("Computer Science Engineering"),
    CE("Civil Engineering"),
    IT("Information Technology"),
    PE("Power Engineering");

    private final String branchName;
    Branch(String branch) {
        this.branchName= branch;
    }
}
