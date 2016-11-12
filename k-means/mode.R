output<- matrix(ncol=11, nrow=1)
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
    
    mat[k] <- count
    
    if(count>max)
    {
      max<-count
      mode<-wisconsin[k,i]
      output[i]<-mode
    }
  }
}
output