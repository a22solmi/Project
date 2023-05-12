# Krav
- Appen skall ha en huvudskärm med en lista (RecyclerView) med er JSON-data
- Appen skall hämta och presentera JSON-data från kursens webbtjänst
- Appens JSON-data är en JSON-array med JSON-objekt. Dessa JSON-objekt måste som minst innehålla attributen ID,Login och 3 ytterligare attribut (totalt minst 5 attribut).
- JSON-arrayen måste som minst innehålla 5 JSON-objekt. Det vill säga minst 5 stycken olika rader med exempel-data måste finnas lagrad i er webbtjänst. T ex, i FamousPeakJSON-tjänsten så är varje berg en rad.
- JSON data hämtas med hjälp av klassen JsonTask
- Er JSON-data skall presenteras med hjälp av en RecyclerView som får sin data via en adapter.
- Appen skall ha en separat "about"-skärm som beskriver appens målgrupp. About-skärm skall vara en egen aktivitet.

Inkludera även lite skärmdumpar/video från appen, i fall det strular med demo vid presentationen. Denna presentation ger ni vid slutseminariumet.

- Varje rad i RecyclerView skall presentera flera fält ur JSON-datan i mer än en (1) view. T ex för Mountan-appen skulle detta kunna vara Bergsnamn och Höjd över havet, eller Bild på berget och Bergsnamn
- Det skall gå att (på valfritt sätt) filtrera vilken data som visas i din recyclerView
  - Det skall gå att spara sitt filter så att det är kvar även om appen startas om
- Ett klick på ett element i er RecyclerView skall öppna en ny detaljvy-activity
- Detaljvyn skall presenter ytterligare information kring det valda element.
  - Detaljvyn skall få all information för presentation via ett Intent
  - Den extra informationen skall även den komma från webbtjänsten. Det vill säga ni skall använda fler av attributen hos er JSON-data i detaljvyn.

# G
- [ ] Presentera en tydligt definierad målgrupp för appen beskriven på en "about"-skärm. About-skärmen skall vara en egen aktivitet.  
- [x] JSON-data till appen skall komma från kursens webbtjänst.  
- [x] Minst ett attribut från appens JSON-data skall presenteras i en RecyclerView.  
- [x] Det måste finns flera meningsfulla commits med programkod som är skapade under flera dagar. Commit-meddelanden skall vara informativa och ge en läsare av commit-loggen en bra överblick av vad som har gjorts i en specifik commit.  
- [ ] Inlämningen ska vara gjord före utsatt deadline.  
- [ ] Presentera er app och aktivt deltaga i kursens slutseminarie.  


# VG

- [x] Varje element i recyclerView skall presentera flera attribut från JSON-datan.  
- [x] Varje element i recyclerView skall ha fler än 1 view.  
- [x] Det skall gå att använda ett filter som avgör vilken data som hämtas. T ex "senaste veckan", "alla tjejer", eller liknande, sagda filter skall inte "nollställas" vid omstart.  
- [x] Det skall finnas en detaljvy som nås via klick i huvudaktiviteten.  
- [x] Detaljvyn skall presentera extra info (fler fält ur JSON-datan) kring det objekt man klickat på.  
- [ ] Detaljvyns data skall vara hämtat från webbtjänsten och skickas via Intent från huvudaktiviteten.  

# Notes
