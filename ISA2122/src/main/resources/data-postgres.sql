SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3175 (class 0 OID 24026)
-- Dependencies: 204
-- Data for Name: authority; Type: TABLE DATA; Schema: public; Owner: postgres

--
--INSERT INTO public.authority (id, name) VALUES (1, 'ROLE_KLIJENT');
--INSERT INTO public.authority (id, name) VALUES (2, 'ROLE_VIKENDICA');
--INSERT INTO public.authority (id, name) VALUES (3, 'ROLE_BROD');
--INSERT INTO public.authority (id, name) VALUES (4, 'ROLE_INSTRUKTOR');
--INSERT INTO public.authority (id, name) VALUES (5, 'ROLE_ADMIN');

-- insert into public.korisnici (id,email, lozinka, poeni, kategorija, penali, enabled, token_id, type) values (1,'markomarkovic@gmail.com','$2y$10$PlcypQuCmM65W7MikuEIW.vBAMLar2o9UQroEu/fpCN/r06BltbOO', 1, 1, 1 ,'true', NULL, 'P');
--
--
-- INSERT INTO public.authorities_korsinik (korisnik_id, authority_id) VALUES (1, 1);
--
-- INSERT INTO public.apoteka (id, naziv, grad, adresa, drzava) VALUES (1, 'Apoteka 1', 'Novi Sad', 'Adresa 1', 'Srbija');
--
-- INSERT INTO public.termin (id, termin_kraj, termin_pocetak) VALUES (1, '10:00', '09:00');
-- INSERT INTO public.termin (id, termin_kraj, termin_pocetak) VALUES (2, '13:30', '13:00');
--
-- INSERT INTO public.tip_pregleda (id, cena, tip, trajanje) VALUES (1, 1000, 0, 30);
--
-- INSERT INTO public.radnje (id, datum, type, izvrsen, definisan, termin_id, strlice_id, pacijent_id, tip_pregleda_id) VALUES (1, '2021-6-25', 'P', true, false, 1, 2, 1, 1);
-- INSERT INTO public.radnje (id, datum, type, izvrsen, definisan, termin_id, strlice_id, pacijent_id) VALUES (2, '2021-6-26', 'S', true, false, 2, 3, 1);
--
--
-- INSERT INTO public.dijagnoze (id, tip) VALUES (1, 0);
--
-- INSERT INTO public.erecept (id, datum_izdavanja, status, pacijent_id) VALUES (1, '2021-6-25', 0, 1);
--
-- INSERT INTO public.izvestaji (id, informacije, dijagnoza_id, recept_id, radnja_id) VALUES (1, 'informacije', 1, 1, 1);
