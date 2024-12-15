import json
from Models.agenda import kontaktuak


class agendakudeatzailea:
    def __init__(self, json_path):
        self.json_path = json_path
        self.kontaktuaklista = []  # Lista hontan gordeko dira

    def kargatu(self):
        
        try:
            with open(self.json_path, 'r') as file:
                data = json.load(file)
                self.kontaktuaklista = [kontaktuak(**entry) for entry in data]  # Listan kargatzen da jsona
        except FileNotFoundError:
            print("Ez da aurkitzen.")  
        except json.JSONDecodeError:
            print("Errorea irakurtzerako orduan.")  

    def erakutsi(self):
        
        if not self.kontaktuaklista:  # Lista utzik dagoen ikusi
            print("Ez da kontakturik kargatu.")
            return
        for banakakontaktuak in self.kontaktuaklista:  # iteratzen doa listan
            print(banakakontaktuak)  

    def borratu(self,email):
        if not self.kontaktuaklista:
            print("Ez dira kargatu kontaktuak")
        kontaktulistaberria = []
        for x in self.kontaktuaklista:
            if (email == (x.email)):
                pass
            else:
                kontaktulistaberria.append(x)
        
        self.kontaktuaklista.clear 
        self.kontaktuaklista = kontaktulistaberria
        self.erakutsi()
        
    
    def edit(self,Kontakto,email):
        if not self.kontaktuaklista:
            print("Ez dira kargatu kontaktuak")
        for i in self.kontaktuaklista:
           for x in self.kontaktuaklista:
            if (email == (x.email)):
               x.abizena = Kontakto.abizena
               x.izena = Kontakto.izena
               x.email = Kontakto.email 
               x.telefonoa = Kontakto.telefonoa
        self.erakutsi()
            
    def jsonIdatzi(self,data):
        try:
            with open(self.json_path, 'w') as file:
                json.dump(data,file)
        except FileNotFoundError:
            print("Ez da aurkitzen.")  
        except json.JSONDecodeError:
            print("Errorea irakurtzerako orduan.")  
        


        