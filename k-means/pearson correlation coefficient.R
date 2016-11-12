library(RMySQL)
mydb = dbConnect(MySQL(), user='root', password='', dbname='k-means', host='localhost')
rs <- dbSendQuery(mydb, "select * from wisconsin;")
data <- fetch(rs, n=699)
wisconsin<-data.frame(data)

output <- matrix( ,11, 11)

for(k in 2:9)
{
  for(l in (k+1):10)
  {
    sum1<-0
    for(i in 1:699)
    {
      sum1<-sum1 +(((wisconsin[i,k]) - mean(wisconsin[,k])) * (wisconsin[i,l] - mean(wisconsin[,l])))
    }
    numerator<-sum1
    sum2<-0
    sum3<-0
    for(m in 1:699)
    {
      sum2<-sum2 + (((wisconsin[m,k]) - mean(wisconsin[,k]))^2)
      sum3<-sum3 + (((wisconsin[m,l]) - mean(wisconsin[,l]))^2)
    }
    sum2<-sum2
    sum3<-sum3
    a<-sqrt(sum2)
    b<-sqrt(sum3)
    denominator<-(a*b)
    output[k,l]<-(numerator/denominator )
  }
}

output