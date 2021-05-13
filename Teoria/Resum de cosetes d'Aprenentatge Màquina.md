# Resum de cosetes d'Aprenentatge Màquina

### Objectiu:

En general, ML (_Machine Learning_) serveix per fer ***predicció***. I jo diferenciaré dos tipos:

- Classificació: quan el que vols predir és un variable categòrica (=que té categories)
- Regressió: quan el que vols predir és una variable continua (=$\forall \varepsilon>0, \exists \delta>0$ tq. ...)

ML també inclou altres àmbits, com _Reinforcement Learning_ del qual no en tinc ni idea. De fet, aquests dos que he escrit són els que s'anomenen _Supervised Learning_.



## Llistat de coses útils

- **Principal Component Analysis**.

IDEA: Agafa les dades que tens a $\R^n$ i les vols passar a $\R^m$ ($m<<n$) conservant la major part d'informació possible.

Serveix per fer reducció dimensional, visualització, extracció de característiques, ...

- **Fisher's Component Analysis**.

IDEA: Agafa les dades que tens a $\R^n$ separades en dues categories, i les projecta a $\R^m$ tal que les dues categories estiguin lo més separades possible.

Serveix per fer reducció dimensional, visualització, ajuda a fer predicció, ...

Quan es fa servir per predir se'n sol dir LDA i té 2 generalitzacions QDA i RDA.

**Nota:** Aquests dos últims métodes són lineals, així que si les dades són complicades, no faran gaires virgueries.

- **Models lineals**

També inclou, Generalized Linear Methods, Lasso, Ridge ...

IDEA: fer prediccions lineals (tot i que es pot modificar) d'una variable independent continua respecte les altres variables explicatives.

Serveix per fer predicció o extracció de característiques, ...

- **Models lineals Generalitzats**

Els models lineals fan regressió lineal, amb els models generalitzats poden usar-se per fer regressió logistica, de poisson, ... que poden ser útils per fer classificaciò.

- **Naive-Bayes**

El full classificador quan tens moltes variables categóriques que expliquen una variable que vols predir.

IDEA: Fa servir BAYES per un tub per dir quina és la més probable. (s'utilitza poc la veritat)

- **kNN** (k-Nearest Neighbours)

El comodí, quan vols fer classificació i no saps molt bé què fer i funciona decent. 

IDEA: vols fer classificació i poses la teva dada juntament amb la resta i mires quin són els seus k veïns més propers i de la classe que tingui més te la quedes com a predicció.

- **Artificial Neural Networks**

Molt fancy però solen utilitzar-se només per problemes molt complicats.

- **Radial basis function network**

És una xarxa neuronal concreta, serveix per fer classificació.

- **Random Forests**

Magia obscura.