package com.overriding;

class HealthcareService {

    void calculateFee() {
        System.out.println("Calculating healthcare fee.");
    }
}

class GeneralConsultation extends HealthcareService {

    @Override
    void calculateFee() {
        System.out.println("General Consultation Fee: ₹500");
    }
}

class SpecialistConsultation extends HealthcareService {

    @Override
    void calculateFee() {
        System.out.println("Specialist Consultation Fee: ₹1500");
    }
}

class EmergencyService extends HealthcareService {

    @Override
    void calculateFee() {
        System.out.println("Emergency Service Fee: ₹3000");
    }
}

public class C_Healthcare {

    public static void main(String[] args) {

        HealthcareService service;

        service = new GeneralConsultation();
        service.calculateFee();

        service = new SpecialistConsultation();
        service.calculateFee();

        service = new EmergencyService();
        service.calculateFee();
    }
}