# Appello
Proposta prof.ssa C. Pellecchia - Rilevazione automatica delle presenze in classe (Appello)
\nL'applicazione una volta avviata da un utente di tipo "Docente" (potrà selezionare l'orario di entrata che di base sarà settato alle 8:00) visualizzerà una lista "Alunni assenti",
man mano che ogni alunno confermerà la propria identità tramite un dispositi NFC il suo nome verrà eliminato dalla lista "Alunni assenti". Passati 10 minuti (ovviamente il tempo
potrà essere modificato dai docenti), gli alunni che si autenticheranno successivamente andranno nella lista "Alunni in ritardo" con accanto l'orario di autenticazione e i minuti
di ritardo.
Il "Docente" avrà una sezione "Uscita anticipata" dove dovrà indicare l'orario, e l'"Alunno" dovrà autenticarsi per confermare la richiesta d'uscita anticipata, dopo l'orario
indicato per uscire, l'"Alunno" dovrà autenticarsi nuovamente per confermare l'uscita. L'applicazione inserirà l'alunno nella lista "Alunni usciti" solo se si è superato l'orario
indicato ed è stata effettuata precedentemente la risciesta d'uscita anticipata.
