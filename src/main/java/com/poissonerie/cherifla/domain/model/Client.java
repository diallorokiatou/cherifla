package com.poissonerie.cherifla.domain.model;

public record Client(String firstname, String surname, String adress, String phone) {
    public Client(ClientBuilder builder) {
        this(builder.firstname, builder.surname, builder.adress, builder.phone);
    }

    public static final class ClientBuilder {
        private String firstname;
        private String surname;
        private String adress;
        private String phone;

        private ClientBuilder() {
        }

        public ClientBuilder withFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public ClientBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public ClientBuilder withAdress(String adress) {
            this.adress = adress;
            return this;
        }

        public ClientBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Client build() {
            return new Client(firstname, surname, adress, phone);
        }
    }
}
