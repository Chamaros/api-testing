package pojos;

public class DataPojo {
  //jsonschema2pojo.org sitesine girdik.
    //postmandan aldigimiz json formati buraya yapistiriyoruz.
    //package a pojos yazdik
    // Class name a DummyRestApiPojo yazdik.
    // source type JSON SECTIK
    // Annotation style : None sectik
    // include getters and setters isaretledik
    // include constructors isaretledik
    // include toString isaretledik
    // daha sonra preview yaptik.
    // pojolar geldi.
    // ilk kisim inner one
    // second one is my actual data





        private Integer id;
        private String employeeName;
        private Integer employeeSalary;
        private Integer employeeAge;
        private String profileImage;


        public DataPojo() {
        }


        public DataPojo(Integer id, String employeeName, Integer employeeSalary, Integer employeeAge, String profileImage) {
            super();
            this.id = id;
            this.employeeName = employeeName;
            this.employeeSalary = employeeSalary;
            this.employeeAge = employeeAge;
            this.profileImage = profileImage;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public Integer getEmployeeSalary() {
            return employeeSalary;
        }

        public void setEmployeeSalary(Integer employeeSalary) {
            this.employeeSalary = employeeSalary;
        }

        public Integer getEmployeeAge() {
            return employeeAge;
        }

        public void setEmployeeAge(Integer employeeAge) {
            this.employeeAge = employeeAge;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", employeeName='" + employeeName + '\'' +
                    ", employeeSalary=" + employeeSalary +
                    ", employeeAge=" + employeeAge +
                    ", profileImage='" + profileImage + '\'' +
                    '}';
        }
        /*    // ASAGIDAKI KISMI SILDIK BI DAHA generate / TOSTRING YAPTIK. YUKARIDAKINI YAPTIK/
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("id");
            sb.append('=');
            sb.append(((this.id == null)?"<null>":this.id));
            sb.append(',');
            sb.append("employeeName");
            sb.append('=');
            sb.append(((this.employeeName == null)?"<null>":this.employeeName));
            sb.append(',');
            sb.append("employeeSalary");
            sb.append('=');
            sb.append(((this.employeeSalary == null)?"<null>":this.employeeSalary));
            sb.append(',');
            sb.append("employeeAge");
            sb.append('=');
            sb.append(((this.employeeAge == null)?"<null>":this.employeeAge));
            sb.append(',');
            sb.append("profileImage");
            sb.append('=');
            sb.append(((this.profileImage == null)?"<null>":this.profileImage));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

 */  // YUKARIDAKI KISMI SILDIK

    }

