package com.rafa.bestofgithub.commons

import com.google.gson.annotations.SerializedName
import com.rafa.bestofgithub.data.remote.dto.ItemsDto

data class Resposta(
    @SerializedName("total_count") var totalCount: Int?= null,
    @SerializedName("incomplete_results") var incompleteResults : Boolean?= null,
    @SerializedName("items") var items: ArrayList<ItemsDto> = arrayListOf()
)
