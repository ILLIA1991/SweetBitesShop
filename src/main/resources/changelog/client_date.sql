INSERT INTO public.client(id, name, surname, email, address, country, phone_number)
VALUES
  (3785, 'Illia', 'Belikau', 'ilasemcenkov1@gmail.com', 'Wroclaw, Hallera 99/13', 'Poland', '48730219815'),
  (3875, 'Maksim', 'Krymov', 'krymau@gmail.com', 'Wroclaw, Stawowa', 'Poland', '48986729826'),
  (3982, 'Anna', 'Nowak', 'annanowak@gmail.com', 'Warsaw, Aleje Jerozolimskie 45', 'Poland', '48670451236'),
  (4021, 'Karolina', 'Kowalska', 'karolinakowalska@gmail.com', 'Krakow, Florianska 28', 'Poland', '48502147698')
   ON CONFLICT (id) DO NOTHING;
