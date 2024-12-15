import json
from Models.agenda import kontaktuak
from Controllers.agendakudeatzailea import agendakudeatzailea
   
kudeatzailea = agendakudeatzailea('agenda.json')

while True:
        print("Menu:")
        print("0. Irten") 
        print("1. Irakurri contactos")
        print("2. Borratu")
        print("3. Editatu") 
        
        aukera = input("sartu aukera: ")

        if not aukera.isdigit():
            print("zenbakia okerra da.")
            continue  

        opcion = int(aukera)  # zenbaki billakatu

        if opcion == 0:
            print("Irten")
            break  
        elif opcion == 1:
            kudeatzailea.kargatu()  # kargatu 
            kudeatzailea.erakutsi()  # Erakutsi
        elif opcion == 2:
            print("Zein da borratu nahi duzun kontaktuaren emaila ?")
            email=input()
            kudeatzailea.borratu(email)
        elif opcion == 3:
            print("Zein da editatu nahi duzun kontaktuaren emaila ?")
            email=input()
            print("Osatu datu hauek")
            izena=input("izena: ")
            abizena=input("abizena: ")
            emaila=input("emaila: ")
            telefonoa=input("telefonoa: ")
            kontaktua = kontaktuak(izena,abizena,telefonoa,emaila)

            kudeatzailea.edit(kontaktua,email)
        else:
            print("Mesdez, irakurri ondo eta sartu aukera aproposena")


