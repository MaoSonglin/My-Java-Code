
public final class Address
{
	private final String detail;
	private final String postCode;

	//在构造方法里初始化两个实例属性
	public Address()
	{
		this.detail = "";
		this.postCode = "";

	}
	public Address(String detail , String postCode)
	{
		this.detail = detail;
		this.postCode = postCode;
	}
	//仅为两个实例属性提供getter方法
	public String getDetail()
	{
		 return this.detail;
	}

	public String getPostCode()
	{
		 return this.postCode;
	}
	//重写equals方法，判断两个对象是否相等。
	public boolean equals(Object obj)
	{
		if (obj instanceof Address)
		{
			Address ad = (Address)obj;
			if (this.getDetail().equals(ad.getDetail()) && this.getPostCode().equals(ad.getPostCode()))
			{
				return true;
			}
		}
		return false;
	}
	public int hashCode()
	{
		return detail.hashCode() + postCode.hashCode();
	}
}