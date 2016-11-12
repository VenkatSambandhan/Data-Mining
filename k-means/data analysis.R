#Loading data from SQL workbench to RStudio.
library(RMySQL)
mydb = dbConnect(MySQL(), user='root', password='', dbname='k-means', host='localhost')
search <- dbSendQuery(mydb, "select * from wisconsin;")
search_result <- fetch(search, n=699)
#Creating data frame named wisconsin
wisconsin<-data.frame(search_result)

#Plotting the histograms for all the attributes and C

#Histogram for clump thickness
hist(wisconsin$Clump.thinkcness, main="Histogram for Clump Thickness", ylab="Frequency of Clump Thickness", xlab="Clump Thickness", col="green", breaks=10)
#Histogram for uniformity of cell size
hist(wisconsin$Uiformity.of.cell.size, main="Histogram for uniformity of cell size", ylab="Frequency of uniformity of cell size", xlab="Uniformity of Cell Size", col="green", breaks=10)
#Histogram for uniformity of call shape
hist(wisconsin$Uniformity.of.call.shape, main="Histogram for uniformity of call shape", ylab="Frequency of uniformity of call shape", xlab="Uniformity of call shape", col="green", breaks=10)
#Histogram for marginal adhesion
hist(wisconsin$Mrginal.adhesion, main="Histogram for marginal adhesion", ylab="Frequency of marginal adhesion", xlab="Marginal adhesion", col="green", breaks=10)
#Histogram for epithelial cell size
hist(wisconsin$Single.epithelial.cell.size, main="Histogram for epithelial cell size", ylab="Frequency of epithelial cell size", xlab="Epithelial cell size", col="green", breaks=10)
#Histogram for bare nuclei
hist(wisconsin$Bare.Nuclei, main="Histogram for bare nuclei", ylab="Frequency of bare nuclei", xlab="Bare nuclei", col="green", breaks=10)
#Histogram for bland chromatin
hist(wisconsin$Bland.chromatin, main="Histogram for bland chromatin", ylab="Frequency of bland chromatin", xlab="Bland chromatin", col="green", breaks=10)
#Histogram for normal nuclei
hist(wisconsin$Normal.nucleoli, main="Histogram for normal nuclei", ylab="Frequency of normal nuclei", xlab="Normal nuclei", col="green", breaks=10)
#Histogram for mitoses
hist(wisconsin$Mitoses, main="Histogram for mitoses", ylab="Frequency of mitoses", xlab="Mitoses", col="green", breaks=10)
#Histogram for class
hist(wisconsin$Class, main="Histogram for class", ylab="Frequency of class", xlab="class", col="green", breaks=2)

#Calculating mean for all attributes

#Mean for clump thickness
mean(wisconsin$Clump.thinkcness)
#Mean for uniformity of cell size
mean(wisconsin$Uiformity.of.cell.size)
#Mean for uniformity of call shape
mean(wisconsin$Uniformity.of.call.shape)
#Mean for marginal adhesion
mean(wisconsin$Mrginal.adhesion)
#Mean for epithelial cell size
mean(wisconsin$Single.epithelial.cell.size)
#Mean for bare nuclei
mean(wisconsin$Bare.Nuclei)
#Mean for bland chromatin
mean(wisconsin$Bland.chromatin)
#Mean for normal nuclei
mean(wisconsin$Normal.nucleoli)
#Mean for mitoses
mean(wisconsin$Mitoses)

#Calculating medeian for all attributes

#Median for clump thickness
median(wisconsin$Clump.thinkcness)
#Median for uniformity of cell size
median(wisconsin$Uiformity.of.cell.size)
#Median for uniformity of call shape
median(wisconsin$Uniformity.of.call.shape)
#Median for marginal adhesion
median(wisconsin$Mrginal.adhesion)
#Median for epithelial cell size
median(wisconsin$Single.epithelial.cell.size)
#Median for bare nuclei
median(wisconsin$Bare.Nuclei)
#Median for bland chromatin
median(wisconsin$Bland.chromatin)
#Median for normal nuclei
median(wisconsin$Normal.nucleoli)
#Median for mitoses
median(wisconsin$Mitoses)


#Calculat mode for all attributes

#Here is the sample code for calculating mode for Class
mat2<-wisconsin$Class
mat1 <- matrix(ncol=1, nrow=699)
max<-0
mode<-0
for(k in 1:699)
{
  count<-0	
  for(j in 1:699)
  {
    if(mat2[k]==mat2[j])
      count<- count + 1
  }
  mat2[k] <- count
  if(count>max)
  {
    max<-count
    mode<-mat2[k]
  }
}
mode

#Here I have calculated the mode for all the columns
output<- matrix(ncol=1, nrow=11)
for(i in 1:11)
{
  max<-0
  mode<-0
  for(k in 1:699)
  {
    count<-0	
    
    for(j in 1:699)
    {
      if(wisconsin[k,i]==wisconsin[j,i])
        count<- count + 1
    }
    
    mat2[k] <- count
    
    if(count>max)
    {
      max<-count
      mode<-wisconsin[k,i]
      output[i]<-mode
    }
  }
}
output


#Calculating variance for all attributes

#Variance for clump thickness
var(wisconsin$Clump.thinkcness)
#Variance for uniformity of cell size
var(wisconsin$Uiformity.of.cell.size)
#Variance for uniformity of call shape
var(wisconsin$Uniformity.of.call.shape)
#Variance for marginal adhesion
var(wisconsin$Mrginal.adhesion)
#Variance for epithelial cell size
var(wisconsin$Single.epithelial.cell.size)
#Variance for bare nuclei
var(wisconsin$Bare.Nuclei)
#Variance for bland chromatin
var(wisconsin$Bland.chromatin)
#Variance for normal nuclei
var(wisconsin$Normal.nucleoli)
#Variance for mitoses
var(wisconsin$Mitoses)