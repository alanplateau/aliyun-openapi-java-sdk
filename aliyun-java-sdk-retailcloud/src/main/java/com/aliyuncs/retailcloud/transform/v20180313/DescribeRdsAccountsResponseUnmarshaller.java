/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliyuncs.retailcloud.transform.v20180313;

import java.util.ArrayList;
import java.util.List;

import com.aliyuncs.retailcloud.model.v20180313.DescribeRdsAccountsResponse;
import com.aliyuncs.retailcloud.model.v20180313.DescribeRdsAccountsResponse.Result;
import com.aliyuncs.retailcloud.model.v20180313.DescribeRdsAccountsResponse.Result.AccountsItem;
import com.aliyuncs.retailcloud.model.v20180313.DescribeRdsAccountsResponse.Result.AccountsItem.DatabasePrivilegesItem;
import com.aliyuncs.transform.UnmarshallerContext;


public class DescribeRdsAccountsResponseUnmarshaller {

	public static DescribeRdsAccountsResponse unmarshall(DescribeRdsAccountsResponse describeRdsAccountsResponse, UnmarshallerContext context) {
		
		describeRdsAccountsResponse.setRequestId(context.stringValue("DescribeRdsAccountsResponse.RequestId"));
		describeRdsAccountsResponse.setCode(context.integerValue("DescribeRdsAccountsResponse.Code"));
		describeRdsAccountsResponse.setErrMsg(context.stringValue("DescribeRdsAccountsResponse.ErrMsg"));

		Result result = new Result();

		List<AccountsItem> accounts = new ArrayList<AccountsItem>();
		for (int i = 0; i < context.lengthValue("DescribeRdsAccountsResponse.Result.Accounts.Length"); i++) {
			AccountsItem accountsItem = new AccountsItem();
			accountsItem.setAccountStatus(context.stringValue("DescribeRdsAccountsResponse.Result.Accounts["+ i +"].AccountStatus"));
			accountsItem.setAccountDescription(context.stringValue("DescribeRdsAccountsResponse.Result.Accounts["+ i +"].AccountDescription"));
			accountsItem.setAccountName(context.stringValue("DescribeRdsAccountsResponse.Result.Accounts["+ i +"].AccountName"));
			accountsItem.setAccountType(context.stringValue("DescribeRdsAccountsResponse.Result.Accounts["+ i +"].AccountType"));
			accountsItem.setPrivExceeded(context.stringValue("DescribeRdsAccountsResponse.Result.Accounts["+ i +"].PrivExceeded"));
			accountsItem.setDBInstanceId(context.stringValue("DescribeRdsAccountsResponse.Result.Accounts["+ i +"].DBInstanceId"));

			List<DatabasePrivilegesItem> databasePrivileges = new ArrayList<DatabasePrivilegesItem>();
			for (int j = 0; j < context.lengthValue("DescribeRdsAccountsResponse.Result.Accounts["+ i +"].DatabasePrivileges.Length"); j++) {
				DatabasePrivilegesItem databasePrivilegesItem = new DatabasePrivilegesItem();
				databasePrivilegesItem.setDBName(context.stringValue("DescribeRdsAccountsResponse.Result.Accounts["+ i +"].DatabasePrivileges["+ j +"].DBName"));
				databasePrivilegesItem.setAccountPrivilege(context.stringValue("DescribeRdsAccountsResponse.Result.Accounts["+ i +"].DatabasePrivileges["+ j +"].AccountPrivilege"));
				databasePrivilegesItem.setAccountPrivilegeDetail(context.stringValue("DescribeRdsAccountsResponse.Result.Accounts["+ i +"].DatabasePrivileges["+ j +"].AccountPrivilegeDetail"));

				databasePrivileges.add(databasePrivilegesItem);
			}
			accountsItem.setDatabasePrivileges(databasePrivileges);

			accounts.add(accountsItem);
		}
		result.setAccounts(accounts);
		describeRdsAccountsResponse.setResult(result);
	 
	 	return describeRdsAccountsResponse;
	}
}