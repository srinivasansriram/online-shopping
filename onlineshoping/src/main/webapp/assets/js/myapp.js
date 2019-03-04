$(function(){
	// solving active mnu probelems
	switch(menu)
	{
	case 'About us':
		$('#about').addClass('active');
		break;
		
		
	case 'Contact us':
		$('#contact').addClass('active');
		break;
	
		
	case 'All Products':
		$('#listproducts').addClass('active');
		break;
		
		default:
			if(menu == "home") break;
			$('#listproducts').addClass('active');
			$('#a_'+menu).addClass('active');
		break;
	}
	
	//code for jquery data table
	//create dataset
	var products = [
		
		['1','a'],
		['2','b'],
		['3','c'],
		['4','d'],
		['5','e'],
		['6','f'],
		['7','g'],
		['8','h']
		
		];
	var $table = $('#productListTable'); 
	
	// execute the below code only when we have this table
	if($table.length) {
		//console.log('inside  the table!');
		
		$table.DataTable({
			
			data:products
		})
	}
	
	
	
	})