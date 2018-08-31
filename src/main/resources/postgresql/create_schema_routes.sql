
use mindssms;
CREATE TABLE  busdetails
(
    busdetails_id integer NOT NULL,
    route_num character varying(255) ,
    CONSTRAINT busdetails_pkey PRIMARY KEY (busdetails_id)
)



CREATE TABLE route
(
    route_id integer NOT NULL,
    destination character varying(255) ,
    source  character varying(255) ,
    CONSTRAINT route_pkey PRIMARY KEY (route_id)
)


--Create busroute_details

CREATE TABLE busroute_details
(
    busdetails_id integer NOT NULL,
    route_id integer NOT NULL,
    CONSTRAINT busroute_details_pkey PRIMARY KEY (busdetails_id, route_id),
    CONSTRAINT busdetails_id FOREIGN KEY (busdetails_id)
        REFERENCES busdetails (busdetails_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT route_id FOREIGN KEY (route_id)
        REFERENCES route (route_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
assignment
    
    
CREATE TABLE traindetails
(
    trainid integer NOT NULL,
    destination character varying(255) ,
    route character varying(255) ,
    source character varying(255) ,
    time bigint,
    type character varying(255) ,
    CONSTRAINT traindetails_pkey PRIMARY KEY (trainid)
)



CREATE TABLE Student
(
    id integer NOT NULL,
    firstname character varying(255) ,
    lastname character varying(255) ,
    email character varying(255) ,
    address character varying(255) ,
    course character varying(255) ,
    time bigint,
    type character varying(255) ,
    CONSTRAINT Student_pkey PRIMARY KEY (id)
)


CREATE TABLE Staff
(
    id integer NOT NULL,
    firstname character varying(255) ,
    lastname character varying(255) ,
    email character varying(255) ,
    address character varying(255) ,
    course character varying(255) ,
    time bigint,
    type character varying(255) ,
    CONSTRAINT Staff PRIMARY KEY (id)
)
