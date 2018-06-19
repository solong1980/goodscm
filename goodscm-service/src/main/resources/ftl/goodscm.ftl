<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>${(shortName)!}</title>
<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
}

.border {
	border: 0px #122345 solid;
}

.center {
	margin: 0px auto;
}

.w960 {
	width: 970px;
	/* position: relative; */
}

.pcenter {
	width: 712px;
	float: left;
	overflow: hidden;
}

.viewbox {
	width: 970px;
	overflow: hidden;
	padding-bottom: 8px;
}

.viewbox .title {
	height: 56px;
	line-height: 56px;
	text-align: center;
	overflow: hidden;
	padding-top: 10px;
}

.viewbox .title h2 {
	font-size: 24px;
	color: #2b2b2b;
}

#baseInfo div {
	margin-bottom: 3px;
}

#baseInfo label {
	width: 180px;
	display: inline-block;
}

#baseInfo span[contenteditable='false'] {
	padding: 3px;
	display: block;
	border: 1px solid blue;
	display: block;
}

/* #baseInfo span[contenteditable='false'] > p:first-child{  
   padding-left: 30px;
} */
#baseInfo span[contenteditable='false']>p {
	padding-top: 5px;
	text-indent: 2em;
}
</style>
</head>
<body>
	<div class="w960 center border">
		<div id="baseInfo" class="viewbox border">
			<div class="title">
				<h2>${(shortName)!}</h2>
			</div>
			<div>
				<label>商品编码:</label><span>${(code)!}</span>
			</div>
			<div>
				<label>简短产品型号名称:</label><span>${(shortName)!}</span>
			</div>
			<div>
				<label>产品分类:</label><span>${(category.name)!}</span>
			</div>
			<div>
				<label>品名中文:</label><span>${(nameZh)!}</span>
			</div>
			<div>
				<label>品名英文:</label><span>${(nameEn)!}</span>
			</div>
			<div>
				<label>净重:</label><span>${(netWeight)!}kg</span>
			</div>
			<div>
				<label>包装后重量:</label><span>${(weightAfterPacking)!}kg</span>
			</div>
			<div>
				<label>包装前体积(Cm) - 长:</label><span>${(length)!}</span>
			</div>
			<div>
				<label>包装前体积(Cm) - 宽:</label><span>${(width)!}</span>
			</div>
			<div>
				<label>包装前体积(Cm) - 高:</label><span>${(height)!}</span>
			</div>
			<div>
				<label>包装后体积(Cm) - 长:</label><span>${(packingLength)!}</span>
			</div>
			<div>
				<label>包装后体积(Cm) - 宽:</label><span>${(packingWidth)!}</span>
			</div>
			<div>
				<label>包装后体积(Cm) - 高:</label><span>${(packingHeight)!}</span>
			</div>
			<div>
				<label>最新采购价:</label><span>${(purchasePrice)!}</span>
			</div>
			<div>
				<label>零售价:</label><span>${(retailPrice)!}</span>
			</div>
			<div>
				<label>批发价:</label><span>${(tradePrice)!}</span>
			</div>
			<div>
				<label>库存数:</label><span>${(stock)!}</span>
			</div>
			<div>
				<label>数量单位:</label><span>${(stockUnit)!}</span>
			</div>
			<div>
				<label>备注:</label><span>${(memo)!}</span>
			</div>
			<div>
				<label>中文信息:</label><span contenteditable="false">${(zhInfo)!}</span>
			</div>
			<div>
				<label>英文信息:</label> <span contenteditable="false">${(enInfo)!}</span>
			</div>
			<div>
				<label>备注信息:</label><span>${(extInfo)!}</span>
			</div>
		</div>
		<p></p>
		
		<#if goodsPics?? && (goodsPics?size > 0)>
			<#assign flag=0>
			<div id="images" class="border">
			  <#list goodsPics as pic>
				  <#if flag == 0><div></#if>
				  	<img src="2016-10-19 2016-10-19 002 001.jpg" width="190" height="150"> 
				  <#assign flag=flag+1>
				  <#if flag == 5>
					</div>
				    <#assign flag=0>
				  </#if>
			  </#list>
			  <#if flag gt 0 ></div></#if>
			</div>
		</#if>
		<div id="description_zh">&nbsp;</div>
		<div id="description_ch">&nbsp;</div>
		<div>&nbsp;</div>
	</div>
</body>
</html>
