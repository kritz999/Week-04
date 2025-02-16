package com.javagenerics.aidrivenresume;

import java.util.ArrayList;
import java.util.List;


    abstract class JobRole {
        private String candidateName;
        private int experienceYears;

        public JobRole(String candidateName, int experienceYears) {
            this.candidateName = candidateName;
            this.experienceYears = experienceYears;
        }

        public String getCandidateName() {
            return candidateName;
        }

        public int getExperienceYears() {
            return experienceYears;
        }

        public abstract String getRoleName();

        @Override
        public String toString() {
            return getRoleName() + " Candidate: " + candidateName + ", Experience: " + experienceYears + " years";
        }
    }

    // Step 2: Define Specific Job Roles
    class SoftwareEngineer extends JobRole {
        public SoftwareEngineer(String candidateName, int experienceYears) {
            super(candidateName, experienceYears);
        }

        @Override
        public String getRoleName() {
            return "Software Engineer";
        }
    }

    class DataScientist extends JobRole {
        public DataScientist(String candidateName, int experienceYears) {
            super(candidateName, experienceYears);
        }

        @Override
        public String getRoleName() {
            return "Data Scientist";
        }
    }

    class ProductManager extends JobRole {
        public ProductManager(String candidateName, int experienceYears) {
            super(candidateName, experienceYears);
        }

        @Override
        public String getRoleName() {
            return "Product Manager";
        }
    }

    // Step 3: Generic Resume Class
    class Resume<T extends JobRole> {
        private List<T> resumes;

        public Resume() {
            this.resumes = new ArrayList<>();
        }

        public void addResume(T resume) {
            resumes.add(resume);
        }

        public List<T> getResumes() {
            return resumes;
        }

        public void displayResumes() {
            for (T resume : resumes) {
                System.out.println(resume);
            }
        }
    }

    // Step 4: Screening Utility with Wildcard Method
    class ResumeScreening {
        public static void processResumes(List<? extends JobRole> resumes) {
            System.out.println("\nProcessing Resumes:");
            for (JobRole resume : resumes) {
                System.out.println("✔ Screening " + resume);
            }
        }
    }


    // Step 5: Testing the AI Screening System
    public class AIDrivenResumeScreeningSystem {
        public static void main(String[] args) {
            // Creating resume categories
            Resume<SoftwareEngineer> softwareResumes = new Resume<>();
            Resume<DataScientist> dataResumes = new Resume<>();
            Resume<ProductManager> pmResumes = new Resume<>();

            // Adding resumes
            softwareResumes.addResume(new SoftwareEngineer("Alice", 5));
            softwareResumes.addResume(new SoftwareEngineer("Bob", 3));

            dataResumes.addResume(new DataScientist("Charlie", 4));
            dataResumes.addResume(new DataScientist("Dave", 6));

            pmResumes.addResume(new ProductManager("Eve", 7));
            pmResumes.addResume(new ProductManager("Frank", 10));

            // Display individual resumes
            System.out.println("Software Engineer Resumes:");
            softwareResumes.displayResumes();

            System.out.println("\nData Scientist Resumes:");
            dataResumes.displayResumes();

            System.out.println("\nProduct Manager Resumes:");
            pmResumes.displayResumes();

            // Processing all resumes dynamically
            ResumeScreening.processResumes(softwareResumes.getResumes());
            ResumeScreening.processResumes(dataResumes.getResumes());
            ResumeScreening.processResumes(pmResumes.getResumes());
        }
    }




