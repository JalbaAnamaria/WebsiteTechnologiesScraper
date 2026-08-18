# Descrierea proiectului
Acest proiect este o aplicație Java care analizează codul HTML al unor website-uri și încearcă să identifice tehnologiile utilizate 
pentru construirea acestora.

Aplicația folosește o abordare bazată pe semnături. Fiecare tehnologie cunoscută este asociată cu una sau mai multe semnături care pot 
apărea în codul HTML al unui website. Atunci când o semnătură este identificată, valoarea weight asociată acesteia contribuie la scorul 
tehnologiei.

## Fluxul aplicației
Fluxul principal al aplicației este următorul:

1. Aplicația primește o listă de website-uri.
2. Pentru fiecare website este obținut conținutul HTML.
3. HTML-ul este analizat pentru a identifica semnături asociate tehnologiilor cunoscute.
4. Pentru fiecare tehnologie detectată sunt păstrate dovezile găsite.
5. Fiecărei semnături îi este asociată o valoare weight care contribuie la calcularea scorului utilizat pentru stabilirea nivelului de
   încredere al detectării.
7. Rezultatele obținute pentru fiecare domeniu sunt încapsulate într-un obiect DomainScanResult.
8. La final, rezultatele sunt exportate într-un fișier JSON.

## Structura proiectului
Pentru a separa responsabilitățile și a menține codul ușor de înțeles, am împărțit aplicația în mai multe clase, fiecare având un rol 
distinct:

### 1. DomainReader
   - conține lista domeniilor care vor fi analizate și o metodă de inițializare care populează această listă
     
### 2. Technology
   - reprezintă o tehnologie și informațiile necesare pentru identificarea acesteia
   - o tehnologie este definită printr-un name și o listă de TechnologySignature
  
### 3. TechnologySignature
   - reprezintă o semnătură utilizată pentru identificarea unei tehnologii
   - o semnătură este definită prin value și weight
   - weight reprezintă importanța unei semnături în procesul de detectare
   - Semnăturile considerate mai specifice sau mai relevante pentru o tehnologie primesc o valoare mai mare, contribuind astfel mai mult la scorul final  
  
### 4. Confidence
   - conține nivelurile de încredere atribuite unei tehnologii, în funcție de scorul obținut în urma identificării semnăturilor asociate
   - poate avea trei valori: HIGH, MEDIUM și LOW
  
### 5. TechnologyRegistry
   - gestionează lista tehnologiilor cunoscute de aplicație
   - lista este populată la inițializarea aplicației, prin metoda initializeTechnologies(), iar getAllTechnologies() permite accesul la
     tehnologiile cunoscute
  
### 6. DetectedTechnology
   - reprezintă rezultatul identificării unei tehnologii și conține informațiile asociate acestei identificări
   - cerința specifică faptul că pentru fiecare tehnologie identificată trebuie furnizate dovezi
   - din acest motiv, am ales să folosesc o clasă distinctă pentru reprezentarea unei tehnologii detectate
   - o tehnologie detectată va avea name, o listă de proofs si confidence
  
### 7. TechnologyDetector
   - are o metodă care încearcă să identifice într-un String (care reprezintă HTML-ul unui website) semnături ale tehnologiilor cunoscute
   - calculează un scor prin însumarea valorilor weight ale semnăturilor identificate, iar pe baza acestui scor stabilește nivelul de
     confidence
   - returnează o listă cu tehnologiile detectate
  
### 8. HtmlReader
   - cuprinde logica de citire a conținutului HTML al unui domeniu și îl returnează
   - aici am întâmpinat cele mai multe dificultăți întrucât nu eram familiarizată cu clasele HttpClient, HttpRequest și HttpResponse
   - Pentru implementarea acestei clase a fost necesară documentarea asupra API-ului Java pentru efectuarea cererilor HTTP și asupra
     modului în care poate fi obținut conținutul HTML al unui website
     
### 9. DomainScanResult
   - reprezintă rezultatul scanării unui domeniu și conține informațiile care vor fi exportate în fișierul JSON
   - un domeniu analizat este definit prin domain și o listă de tehnologii detectate
  
### 10. JsonExporter
   - transformă rezultatele scanării într-un document JSON și îl scrie în fișierul results.json
    
### 11. Main
   - reprezintă punctul de pornire al aplicației
   - parcurge lista de domenii
   - coordonează citirea HTML-ului, detectarea tehnologiilor și exportul rezultatelor

## Debate Topics
### I. Problemele principale ale implementării actuale
Implementarea actuală reprezintă o versiune simplificată a unui sistem de identificare a tehnologiilor și are câteva limitări care ar 
putea fi abordate într-o versiune viitoare.

#### 1. Detectarea se bazează doar pe codul HTML
În versiunea actuală, aplicația analizează conținutul HTML primit prin request HTTP. Din documentarea pe care am făcut-o pe acest subiect,
tehnologiile pot lăsa însă indicii și în alte surse, cum ar fi HTTP headers, cookies, JavaScript, URL-uri.

#### 2. Posibilitatea apariției unor rezultate false positive
În implementarea actuală, o semnătură este identificată folosind o căutare simplă în conținutul HTML. Această abordare poate produce
rezultate incorecte atunci când o semnătură este prea generală și apare în HTML fără ca tehnologia respectivă să fie utilizată.

Pentru această versiune a aplicației, inițial am creat o clasă separată de testare a detectorului pentru câteva domenii si tehnologii, îniante de a adăuga
mai multe. Astfel, au apărut și rezultate false positive în cazul semnăturilor prea generale.

Pentru a reduce aceste cazuri, semnăturile ar putea fi mai precise.

#### 3. Procesarea domeniilor durează prea mult
În momentul de față, domeniile sunt analizate unul câte unul. Pentru un număr mic de domenii această abordare este suficientă, însă pentru
un număr foarte mare de website-uri, timpul total de execuție ar crește considerabil.
Acest aspect ar putea fi îmbunătățit prin procesarea mai multor domenii în același timp.

#### 4. Lista tehnologiilor este inclusă direct în cod
Lista tehnologiilor este definită în TechnologyRegistry. Acest lucru este suficient pentru versiunea actuală, dar
adăugarea sau modificarea tehnologiilor necesită modificarea codului.
Într-o versiune viitoare, definițiile tehnologiilor ar putea fi mutate într-un fișier extern. Astfel, noi tehnologii și semnături ar
putea fi adăugate fără modificarea logicii principale.

### II. Scalarea soluției
În implementarea actuală, domeniile sunt analizate unul câte unul. Pentru fiecare domeniu este efectuat un request HTTP, iar după primirea
răspunsului este realizată detectarea tehnologiilor. Această abordare înseamnă că timpul de așteptare pentru un domeniu îl întârzie pe 
următorul.
O soluție mai scalabilă ar putea folosi un sistem care procesează mai multe domenii în paralel.

### III. Descoperirea de noi tehnologiilor
Lista de tehnologii cunoscute poate fi extinsă pe măsură ce apar tehnologii noi.
Pentru a adăuga o tehnologie nouă, aș identifica mai întâi elementele specifice pe care aceasta le lasă în HTML.
Aceste elemente pot fi apoi adăugate ca TechnologySignature.

O altă modalitate de a descoperi tehnologii noi ar fi analizarea website-urilor care conțin pattern-uri pe care aplicația nu le 
recunoaște. Dacă anumite pattern-uri apar frecvent, acestea pot fi investigate pentru a determina dacă sunt asociate unei tehnologii 
necunoscute.

Structura actuală a aplicației permite adăugarea unor tehnologii noi fără modificarea logicii din TechnologyDetector, deoarece 
tehnologiile și semnăturile acestora sunt separate de logica de detectare.
