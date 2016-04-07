List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
List<Integer> odds = new ArrayList();
for (Integer i : list)
	if (i % 2 == 0)
		odds.add(i);

for (Integer i : odds)
	print(i + ", ")
