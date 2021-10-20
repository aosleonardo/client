CREATE TABLE "builders".client (
	id uuid PRIMARY KEY,
	"name" varchar(500) NOT NULL,
	birth_date date NOT NULL,
	"document" varchar(11) NOT NULL
);

