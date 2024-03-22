package com.java_spring.java_spring_crud.services.constants;

public class Messages {
    public static class User{

        public static String userAddSuccess = "User.userAddSuccess";
        public static String userUpdateSuccess = "User.userUpdateSuccess";
        public static String userDeleteSuccess = "User.userDeleteSuccess";
        public static String getUserNotFoundMessage ="User.getUserNotFoundMessage";
        public static String getUserMailAlreadyExistsMessage="User.getUserMailAlreadyExistsMessage";
        public static String userRegisterSuccess="User.userRegisterSuccess";
        public static String userLoginSuccess="User.userLoginSuccess";
        public static String userCredentialsIncorrectMessage="User.userCredentialsIncorrectMessage";
    }


    public static class Brand{
        public static String brandAddSuccess = "Brand.brandAddSuccess";
        public static String brandUpdateSuccess = "Brand.brandUpdateSuccess";
        public static String brandDeleteSuccess = "Brand.brandDeleteSuccess";
        public static String getBrandNotFoundMessage ="Brand.getBrandNotFoundMessage";
        public static String getBrandNameAlreadyExistsMessage="Brand.getBrandNameAlreadyExistsMessage";
    }

    public static class Car{
        public static String carAddSuccess = "Car.carAddSuccess";
        public static String carUpdateSuccess = "Car.carUpdateSuccess";
        public static String carDeleteSuccess = "Car.carDeleteSuccess";
        public static String getCarNotFoundMessage ="Car.getCarNotFoundMessage";
        public static String getSameCarPlateMessage="Car.getSameCarPlateMessage";
    }

    public static class Employee{
        public static String employeeAddSuccess = "Employee.employeeAddSuccess";
        public static String employeeUpdateSuccess = "Employee.employeeUpdateSuccess";
        public static String employeeDeleteSucess = "Employee.employeeDeleteSuccess";
        public static String employeeNotFoundMessage = "Employee.employeeNotFoundMessage";
    }

}
