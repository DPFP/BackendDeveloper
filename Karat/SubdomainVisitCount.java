public class SubdomainVisitCount {

    // 811. Subdomain Visit Count
    // https://leetcode.com/problems/subdomain-visit-count/
    public List<String> subdomainVisits(String[] cpdomains) {
        // 1, use map to keep track of the count
        // 2, split by space (number + domain)
        // 3, split by peroid (subdomains)

        // key: domain, value: count
        Map<String, Integer> counter = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] cpd = cpdomain.split("\\s+");
            String[] frags = cpd[1].split("\\.");

            int count = Integer.valueOf(cpd[0]);

            String domain = "";
            for (int i = frags.length - 1; i >= 0; i--) {
                domain = frags[i] + (i < frags.length - 1 ? "." : "") + domain;
                counter.put(domain, counter.getOrDefault(domain, 0) + count);
            }
        }

        StringBuilder sb = new StringBuilder();
        List<String> res = new LinkedList<>();

        for (String domain : counter.keySet()) {
            sb.setLength(0);
            sb.append(counter.get(domain));
            sb.append(" ");
            sb.append(domain);
            res.add(sb.toString());
        }

        return res;
    }
}
