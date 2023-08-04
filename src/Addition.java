
class Addition
{ public static void main(String args[])
{ double [][] x={{1,2.3,3},{4,5.4,6},{7,8,9}};
double [][] y={{1.1,1.2,1.3},{14,1.5,1.6},{1.7,1.8,1.9}};
double [][] z=new double[3][3];
for(int i=0; i<3; i++)
for(int j=0; j<3; j++)
{ z[i][j]=x[i][j]+y[i][j];
}
for(int i=0; i<3; i++)
{ for(int j=0; j<3; j++)
{ System.out.print(z[i][j]+" ");
}
System.out.print("\n");
}
}
}
