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

-- insert into public.korisnici (id,email, lozinka, poeni, kategorija, penali, enabled, token_id, type) values (1,'markomarkovic@gmail.com','$2a$10$OPg8PknaAhG5QvTDPxpKtutf7I124RSwlw1NO7ilsKvbtda6u3ELy', 1, 1, 1 ,'true', NULL, 'P');
--
--
-- INSERT INTO public.authorities_korsinik (korisnik_id, authority_id) VALUES (1, 1);
--
