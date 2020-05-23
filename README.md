## Pascariu Mihaela-Diana
# FII LAB 8
* Compulsory :
    * Pentru a crea baza de date am folosit MySql.
    * Am folosit modelul DAO pentru a implementa problema, avand astfel interfertele AlbumController si ArtistController.
    * In clasele Artist si Album am metodele si atributele aferente claselor.
    * In clasele ArtistDAO si AlbumDAO am metodele suprascrise ale interfetelor + conexiunea cu baza de date.
    * In Main, pentur am testat functionalitatile claselor.
* Optional :
	* Am implemetat si aici toate cerintele.
	* Am facut tabela AlbumChart, in care se stocheaza albumele si pozitia lor in top.
	* Am clasa AlbumChart, pentru a stoca atribute, getters si setters.
	* Am interfata AlbumChartController, cu metoda de create. Aceasta imi returneaza o lista de albume.
	* Am si metoda de printare a chartului.
	* In metoda de printare, obiectele sunt ordonate dupa pozitia lor in chart.
* Bonus: 
	* Am implementat clasa ConnectionPool
	* Am implementat clasa MyThreadPoolExecutor
	* Am implementat clasa ArtistThread
	* Intr-un for, am creat 15 thread-uri executate de MyThreadPoolExecutor folosind ConnectionPool pentru a executa un query din baza de date.