package com.example.shoppinglist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ShoppingItems(val id:Int,
                         var name:String,
                         var quantity:Int,
                         var isEditing : Boolean = false)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingList(){

    var sItems by remember { mutableStateOf(listOf<ShoppingItems>())}
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQty by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    text = "Shopping list",
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                ) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {showDialog = true}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp,
                    vertical = 8.dp,)) {
                items(sItems){
                    item ->
                    if(item.isEditing){
                        ShoppingItemEditor(item = item, onEditComplete = {
                            editedName,editedQuantity ->
                            sItems = sItems.map { it.copy(isEditing = false) }
                            val editedItem = sItems.find{it.id == item.id}
                            editedItem?.let {
                                it.name = editedName
                                it.quantity = editedQuantity
                            }
                        })
                    }
                    else {
                        ShoppingListItems(item = item,
                            onEditCLick = { sItems = sItems.map { it.copy(isEditing = it.id==item.id) } },
                            onDeleteClick = { sItems = sItems-item })
                    }
                }
            }

        }
        if(showDialog){
            AlertDialog(onDismissRequest = { showDialog = false },
                confirmButton = {
                                Row (modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                    ){
                                    Button(onClick = {
                                        if(itemName.isNotEmpty()){
                                            val newItem = ShoppingItems(
                                                id = sItems.size+1,
                                                name = itemName,
                                                quantity = itemQty.toInt()
                                            )
                                            sItems = sItems + newItem
                                            showDialog = false
                                            itemName = ""
                                            itemQty = ""
                                        }

                                    }) {
                                        Text(text = "ADD")
                                    }
                                    Button(onClick = { showDialog = false }) {
                                        Text(text = "CANCEL")
                                    }
                                }
                },
                title = { Text(
                    text = "ADD SHOPPING ITEM",
                    modifier = Modifier.padding(15.dp)
                    )},
                text = {
                    Column {
                        OutlinedTextField(
                            value = itemName,
                            onValueChange = { itemName = it },
                            placeholder = { Text(text = "ENTER ITEM NAME") },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                            )
                        OutlinedTextField(
                            value = itemQty,
                            onValueChange = { itemQty = it },
                            placeholder = { Text(text = "ENTER ITEM QUANTITY") },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }
                }
                )
        }

    }
}

@Composable
fun ShoppingItemEditor(item:ShoppingItems, onEditComplete: (String,Int) -> Unit){
    var editedName by remember { mutableStateOf(item.name) }
    var editedQuantity by remember { mutableStateOf(item.quantity.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {
        Column {
            BasicTextField(
                value = editedName,
                onValueChange = {editedName = it},
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
            BasicTextField(
                value = editedQuantity,
                onValueChange = {editedQuantity = it},
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
        }
        Button(onClick = {
            isEditing = false
            onEditComplete(editedName, editedQuantity.toIntOrNull() ?: 1)
        })
        {
            Text(text = "SAVE")
            
        }

    }

}


@Composable
fun ShoppingListItems(
  item:ShoppingItems,
  onEditCLick: () -> Unit,
  onDeleteClick:() ->Unit,
) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .border(
            border = BorderStroke(2.dp, Color.Cyan),
            shape = RoundedCornerShape(20)

        ),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = item.name, modifier = Modifier.padding(8.dp))
        Text(text = "QTY :${item.quantity}", modifier = Modifier.padding(8.dp))
        Row (modifier = Modifier.padding(8.dp)){
            IconButton(onClick =  onEditCLick ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
            IconButton(onClick =  onDeleteClick ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }

}



@Composable
@Preview
fun ShoppingListPreview(){
    ShoppingList()
}
