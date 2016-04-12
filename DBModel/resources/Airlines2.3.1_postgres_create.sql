CREATE TABLE "flight" (
	"id" serial NOT NULL,
	"aircraft id" integer NOT NULL,
	"departure_point_name" character varying(50) NOT NULL,
	"departure_airport" character varying(50) NOT NULL,
	"departure_time" timestamp with time zone NOT NULL,
	"destination_point_name" character varying(50) NOT NULL,
	"destination_airport" character varying(50) NOT NULL,
	"аrrival_time" timestamp with time zone NOT NULL,
	CONSTRAINT flight_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "aircraft" (
	"id" serial NOT NULL,
	"aircraft_number" character varying(50) NOT NULL,
	"name" character varying(50) NOT NULL,
	"number_of_seats" int NOT NULL,
	"max_range" int NOT NULL,
	"cruising_speed" int NOT NULL,
	"max_speed" int NOT NULL,
	"max_transported_cargo" int NOT NULL,
	"max_cargo_capacity" int NOT NULL,
	"service_ceiling" int NOT NULL,
	CONSTRAINT aircraft_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "employee" (
	"id" serial NOT NULL,
	"specialty" int NOT NULL,
	"name" character varying(50) NOT NULL,
	"surname" character varying(50) NOT NULL,
	"gender" int NOT NULL,
	"date_of_birth" DATE NOT NULL,
	"photo" character varying(100),
	"description" character varying(1000),
	"employment_date" DATE NOT NULL,
	CONSTRAINT employee_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "employee_2_flight" (
	"employee_id" integer NOT NULL,
	"flight_id" integer NOT NULL,
	CONSTRAINT employee_2_flight_pk PRIMARY KEY ("employee_id","flight_id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user" (
	"id" serial NOT NULL,
	"email" character varying(50) NOT NULL,
	"password" character varying(50) NOT NULL,
	"role" int NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "aircraft_crew" (
	"id" int NOT NULL,
	"specialty" int NOT NULL,
	"number" int NOT NULL,
	CONSTRAINT aircraft_crew_pk PRIMARY KEY ("id","specialty")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "route" (
	"point_numder" int NOT NULL,
	"flight_id" int NOT NULL,
	"coordinates" point NOT NULL,
	"altitude" int NOT NULL,
	CONSTRAINT route_pk PRIMARY KEY ("point_numder")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "flight" ADD CONSTRAINT "flight_fk0" FOREIGN KEY ("aircraft id") REFERENCES "aircraft"("id");


ALTER TABLE "employee" ADD CONSTRAINT "employee_fk0" FOREIGN KEY ("specialty") REFERENCES "specialty"("id");

ALTER TABLE "employee_2_flight" ADD CONSTRAINT "employee_2_flight_fk0" FOREIGN KEY ("employee_id") REFERENCES "employee"("id");
ALTER TABLE "employee_2_flight" ADD CONSTRAINT "employee_2_flight_fk1" FOREIGN KEY ("flight_id") REFERENCES "flight"("id");

ALTER TABLE "user" ADD CONSTRAINT "user_fk0" FOREIGN KEY ("id") REFERENCES "employee"("id");

ALTER TABLE "aircraft_crew" ADD CONSTRAINT "aircraft_crew_fk0" FOREIGN KEY ("id") REFERENCES "aircraft"("id");

ALTER TABLE "route" ADD CONSTRAINT "route_fk0" FOREIGN KEY ("flight_id") REFERENCES "flight"("id");

