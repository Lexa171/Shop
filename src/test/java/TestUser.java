/**
 * Created by Admin on 10.05.2017.
 */
public class TestUser {
    /*    private EmbeddedDatabase embeddedDatabase;

        private JdbcTemplate by.onlineStore.bean.repository;

        private UserRepository userRepository;

        @Before
        public void setUp() {
          *//*  embeddedDatabase = new EmbeddedDatabaseBuilder()
                    .addDefaultScripts()
                    .setType(EmbeddedDatabaseType.H2)
                    .build();
*//*
            by.onlineStore.bean.repository = new JdbcTemplate(embeddedDatabase);

            userRepository = new UserRepositoryImpl(by.onlineStore.bean.repository);
        }

        @Test
        public void testFindAll() {
            Assert.assertNotNull( userRepository.getAllUsers());
            Assert.assertEquals(2,  userRepository.getAllUsers().size());
        }

        @Test
        public void testFindOne() {
            Assert.assertNull(userRepository.findById(1));
            Assert.assertNotNull(userRepository.findById(1));
        }

        @Test
        public void testSave() {
            userRepository.saveOrUpdateUser(new User(1,"Jim Beam", "jimbeam@example.com",
                    "123"));
            User user =userRepository.findById(1);
            Assert.assertNotNull(user);
            Assert.assertNotNull(user.getIdUser());
            Assert.assertEquals("Jim Beam", user.getNameUser());
        }*/
/*
        @Test(expected = DataIntegrityViolationException.class)
        public void testSaveInvalid() {
            personRepository.save(new Person());
        }

        @Test(expected = DataIntegrityViolationException.class)
        public void testSaveConflict() {
            personRepository.save(new Person("Jim Beam", "jackdaniels@example.com"));
        }

        @Test
        public void testUpdate() {
            Person person = by.onlineStore.bean.repository.queryForObject("select * from person where id = 'jack-daniels'", PersonRepository.ROW_MAPPER);
            person.setName("Johny Walker");

            person = personRepository.save(person);
            Assert.assertNotNull(person);
            Assert.assertNotNull(person.getId());
            Assert.assertEquals("Johny Walker", person.getName());
        }

        @Test(expected = DataIntegrityViolationException.class)
        public void testUpdateInvalid() {
            Person person = by.onlineStore.bean.repository.queryForObject("select * from person where id = 'jack-daniels'", PersonRepository.ROW_MAPPER);
            person.setName(null);

            personRepository.save(person);
        }

        @Test(expected = DataIntegrityViolationException.class)
        public void testUpdateConflict() {
            Person person = by.onlineStore.bean.repository.queryForObject("select * from person where id = 'jack-daniels'", PersonRepository.ROW_MAPPER);
            person.setEmail("georgedickel@example.com");

            personRepository.save(person);
        }

        @Test
        public void testDelete() {
            Assert.assertEquals(1, personRepository.delete("jack-daniels"));
            Assert.assertEquals(0, personRepository.delete("nonexistent-id"));
        }

        @After
        public void tearDown() {
            embeddedDatabase.shutdown();
        }
    }*/
}
