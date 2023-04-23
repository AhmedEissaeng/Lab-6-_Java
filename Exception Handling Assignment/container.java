class container implements Comparable<container>
{
    private String id;
    private String sh_name;
    private String lon_name;
    public void setid(String i)
    {
    	this.id=i;
    }
    public void setsh_name(String s)
    {
    	this.sh_name=s;
    }
    public void setlon_name(String l)
    {
    	this.lon_name=l;
    }
    public String getid()
    {
    	return this.id;
    }
    public String getsh_name()
    {
    	return this.sh_name;
    }
    public String getlon_name()
    {
    	return this.lon_name;
    }
    @Override
    public String toString()
    {
    	return"    <CONTAINER UUID="+this.id+">\n"+
    	"        <SHORT-NAME>"+this.sh_name+"<SHORT-NAME>\n"+
        "        <LONG-NAME>"+this.lon_name+"<LONG-NAME>\n"+
        "    </CONTAINER>\n";
    }
    @Override 
    public int compareTo(container w)
    {
    	if(this.getsh_name().charAt(9)>w.getsh_name().charAt(9))
    		return 1;
    	else if(this.getsh_name().charAt(9)<w.getsh_name().charAt(9))
    		return -1;
    	else 
    		return 0;
    }
}