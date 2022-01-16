package com.zensar.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderTotals {

	private String totalPurchaseAmount;
	private String seperatorOrderTotals0;
}
