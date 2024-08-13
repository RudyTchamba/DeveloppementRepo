public class Surviving{
	public static void main(String[] args)
	{
		//Entry 1
		Cat cat = new Cat("Cat"+0,2,"Male");
		cat.listCat[cat.nbCat]=cat;
		cat.nbCat++;
		Mouse mouse = new Mouse("Mouse"+0,5,"Female");
		mouse.listMouse[mouse.nbMouse]=mouse;
		mouse.nbMouse++;
		Maize maize = new Maize("Maize"+0,7);
		maize.listMaize[maize.nbMaize]=maize;
		maize.nbMaize++;
		//Entry 2
		cat = new Cat("Cat"+cat.nbCat,20,"Male");
		cat.listCat[cat.nbCat]=cat;
		cat.nbCat++;
		mouse = new Mouse("Mouse"+mouse.nbMouse,25,"Female");
		mouse.listMouse[mouse.nbMouse]=mouse;
		mouse.nbMouse++;
		maize = new Maize("Maize"+maize.nbMaize,13);
		maize.listMaize[maize.nbMaize]=maize;
		maize.nbMaize++;
		//Entry 3
		cat = new Cat("Cat"+cat.nbCat,1,"Male");
		cat.listCat[cat.nbCat]=cat;
		cat.nbCat++;
		mouse = new Mouse("Mouse"+mouse.nbMouse,12,"Female");
		mouse.listMouse[mouse.nbMouse]=mouse;
		mouse.nbMouse++;
		maize = new Maize("Maize"+maize.nbMaize,19);
		maize.listMaize[maize.nbMaize]=maize;
		maize.nbMaize++;
		//Entry 4
		cat = new Cat("Cat"+cat.nbCat,9,"Male");
		cat.listCat[cat.nbCat]=cat;
		cat.nbCat++;
		mouse = new Mouse("Mouse"+mouse.nbMouse,6,"Female");
		mouse.listMouse[mouse.nbMouse]=mouse;
		mouse.nbMouse++;
		//Entry 5
		cat = new Cat("Cat"+cat.nbCat,11,"Male");
		cat.listCat[cat.nbCat]=cat;
		cat.nbCat++;
		mouse = new Mouse("Mouse"+mouse.nbMouse,4,"Female");
		mouse.listMouse[mouse.nbMouse]=mouse;
		mouse.nbMouse++;
		int i,j,k;
		int m;
		while(cat.nbCat+mouse.nbMouse+maize.nbMaize>0)
		{
			try {
			   System.out.println("*********************************************************************");
			   Printtile(cat,mouse,maize);
			   // faire une pause de 1 seconds
			   Thread.sleep(1000);
			   //String command = "cls";
			   Runtime runtime = Runtime.getRuntime();
			   Process process = null;
			   for(i=0;i<cat.nbCat;i++)
			   {
			   	k=0;
			   	for(m=i+1;m<cat.nbCat;m++)
			   	{
			   		if(cat.listCat[m].mPosition==cat.listCat[i].mPosition)
			   		{
			   			if(cat.listCat[m].mSex!=cat.listCat[i].mSex)
			   				cat.Reproduction();
			   			else
			   				cat.listCat[m].moveEntity(1+(int)(Math.random() * 25));
			   		}			
			   	}
			   	for(m=0;m<mouse.nbMouse;m++)
			   	{
			   		if(mouse.listMouse[m].mPosition==cat.listCat[i].mPosition)
			   		{
			   			cat.listCat[i].KillMouse(mouse.listMouse[m]);
			   			k++;
			   		}
			   	}
			   	if(k==0)
			   	{
			   		cat.listCat[i].HealthDown();
			   	}
			   	cat.listCat[i].moveEntity(1+(int)(Math.random() * 25));
			   }
			   for(k=0;k<mouse.nbMouse;k++)
			   {
			   	i=0;
			   	for(m=k+1;m<mouse.nbMouse;m++)
			   	{
			   		if(mouse.listMouse[m].mPosition==mouse.listMouse[k].mPosition)
			   		{
			   			if(mouse.listMouse[m].mSex!=mouse.listMouse[k].mSex)
			   				mouse.Reproduction();
			   			else
			   				mouse.listMouse[m].moveEntity(1+(int)(Math.random() * 25));
			   		}			
			   	}
			   	for(m=0;m<maize.nbMaize;m++)
			   	{
			   		if(mouse.listMouse[k].mPosition==maize.listMaize[m].mPosition)
			   		{
			   			mouse.listMouse[k].EatMaize(maize.listMaize[m]);
			   			i++;
			   		}
			   	}
			   	if(k==0)
			   	{
			   		mouse.listMouse[k].HealthDown();
			   	}
			   	mouse.listMouse[k].moveEntity(1+(int)(Math.random() * 25));
			   }
			   for(j=0;j<maize.nbMaize;j++)
			   {
			   	maize.listMaize[j].QualityDown();
			   }
			   try
			   {
				process = runtime.exec("clear");
			   } catch(Exception err) {;}
		   	} catch (InterruptedException e) {
		    		e.printStackTrace(); 
			}
		}
	}
	public static void Printtile(Cat cat, Mouse mouse, Maize maize)
	{
		int i,j,k,n,size=5;
		String tile="",tmp="";
		for(i=1;i<=(size*size);i++)
		{
			tmp="";
			if(i%size==0)
			{
				for(j=0;j<cat.nbCat;j++)
				{
					if(cat.listCat[j].mPosition==i)
					{
						tmp="      "+cat.listCat[j].mName+"("+cat.listCat[j].mSex+")\n\n\n";
					}
					else
					{
						for(k=0;k<mouse.nbMouse;k++)
						{
							if(mouse.listMouse[k].mPosition==i)
							{
								tmp="      "+mouse.listMouse[k].mName+"("+mouse.listMouse[k].mSex+")\n\n\n";
							}
							else
							{
								for(n=0;n<maize.nbMaize;n++)
								{
									if(maize.listMaize[n].mPosition==i)
									{
										tmp="      "+maize.listMaize[n].mName+"\n\n\n";
									}
								}
							}
						}
					}
				}
				if(tmp=="")
				{
					tile+="      \n\n\n";
				}
				else
				{
					tile+=tmp;
				}
			}
			else
			{
				for(j=0;j<cat.nbCat;j++)
				{
					if(cat.listCat[j].mPosition==i)
					{
						tmp="      "+cat.listCat[j].mName+"("+cat.listCat[j].mSex+")";
					}
					else
					{
						for(k=0;k<mouse.nbMouse;k++)
						{
							if(mouse.listMouse[k].mPosition==i)
							{
								tmp="      "+mouse.listMouse[k].mName+"("+mouse.listMouse[k].mSex+")";
							}
							else
							{
								for(n=0;n<maize.nbMaize;n++)
								{
									if(maize.listMaize[n].mPosition==i)
									{
										tmp="      "+maize.listMaize[n].mName;
									}
								}
							}
						}
					}
				}
				if(tmp=="")
				{
					tile+="      ";
				}
				else
				{
					tile+=tmp;
				}
			}
		}
		System.out.println(tile);
		System.out.println("Total Cat : "+cat.nbCat+"\nTotal Mouse : "+mouse.nbMouse+"\nTotal Maize : "+maize.nbMaize);
	}
}
