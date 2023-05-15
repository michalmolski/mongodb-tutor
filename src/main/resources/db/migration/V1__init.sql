
CREATE TABLE public.sent_events_table (
	event_id int8 NOT NULL,
	event_class varchar(30) NULL NULL,
	event_alarm bool NULL,
	gps_point jsonb NULL,
	event_start_timestamp timestamp NULL,
	event_detect_timestamp timestamp NULL,
	"attributes" jsonb NULL,
	business_id varchar(12) NULL,
	wojewodeship varchar(30) NULL,
	CONSTRAINT sent_events_table_pkey PRIMARY KEY (event_id)
);
create sequence hibernate_sequence;
