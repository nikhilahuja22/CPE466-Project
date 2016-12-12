Our project uses the kNN algorithm to classify users into their likely income class.


The program first prompts the user for three attributes; age, education level, and hours worked per week. This is sufficient for classification, but several filters, such as occupation and marital status, can be applied to reduce the dataset.


Once the user is satisfied with their input, the kNN algorithm measures the Euclidian distance of every tuple using the three attributes inputted by the user. The number of nearest points we are looking for, named k, is determined by cross validation. Next, the majority classification of the k nearest points is used to decide the classification for the user inputted tuple.


The output of the kNN algorithm is whether or not the user inputted data will make over or under 50k in yearly income. After running the kNN algorithm, a bagging algorithm is run to test the accuracy of the kNN data. The bagging is done by creating k amount, 50 in this case, of randomized datasets, running the kNN algorithm on each of the datasets, and choosing the majority classification of those results. The result of bagging is outputted after the result of the original kNN algorithm. 


The results are interesting because this program has a way of predicting a person’s yearly income based on a myriad of factors.

LOG:
Nikhil Ahuja
KNN algorithm (KNN.java)
Sindhuja Ramini
User input (InputManager.java)
Filtering (KNN.java)
Nathan Sylvia
Bagging (Project.java)
Gideon Wong
User input
Filtering
Cross validation (KChooser.java)



